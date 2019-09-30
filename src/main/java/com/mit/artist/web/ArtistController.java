package com.mit.artist.web;

import com.mit.artist.domain.Artist;
import com.mit.artist.service.ArtistService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("artist")
public class ArtistController {

    /**
     * 性別の表示に使用するアイテム
     */
    final static Map<String, String> GENDER_ITEMS =
            Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
                {
                    put("1", "lable.six.female");
                    put("2", "lable.six.male");
                }
            });

    @Autowired
    ArtistService artistService;

    @ModelAttribute
    ArtistForm setUpForm() {
        return new ArtistForm();
    }

    @GetMapping(path = "list")
    String list(Model model, @Validated SearchForm form, @RequestParam(required = false) String lang) {
        List<Artist> artists = artistService.find(form.getName());
        model.addAttribute("artists", artists);
        model.addAttribute("lang", lang);
        return "artist/list";
    }

    @GetMapping(path = "create", params = "form")
    String create(Model model) {
        model.addAttribute("genderItems", GENDER_ITEMS);
        return "artist/create";
    }

    @PostMapping(path = "create")
    String create(@Validated ArtistForm form,
                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            return create(model);
        }

        Artist artist = new Artist();
        BeanUtils.copyProperties(form, artist);
        artist.setUpdateTime(LocalDateTime.now());
        artistService.create(artist);
        return "redirect:/artist/list";
    }

    @GetMapping(path = "edit", params = "form")
    String edit(@RequestParam Integer id,
                ArtistForm form, Model model) {
        Artist artist = artistService.findById(id);
        BeanUtils.copyProperties(artist, form);
        model.addAttribute("genderItems", GENDER_ITEMS);
        return "artist/edit";
    }

    @PostMapping(path = "edit")
    String edit(@RequestParam Integer id,
                @Validated ArtistForm form,
                BindingResult result, Model model) {
        if (result.hasErrors()) {
            return edit(id, form, model);
        }

        Artist artist = new Artist();
        BeanUtils.copyProperties(form, artist);
        artist.setId(id);
        artist.setUpdateTime(LocalDateTime.now());
        artistService.upadte(artist);
        return "redirect:/artist/list";
    }

    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
        artistService.delete(id);
        return "redirect:/artist/list";
    }

    @GetMapping(path = "top")
    String goToTop() {
        return "redirect:/artist/list";
    }

}

package com.sjsu.cmpe275.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

/**
 * Created by huimin on 3/24/16.
 */

@Controller
public class ProfileController {

    @Autowired
    ProfileDao profileDao;

    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ModelAndView emptyProfile() {
        Profile profile = new Profile();
        ModelAndView mav = new ModelAndView("profile");
        mav.addObject("profile",profile);
        return mav;
    }

    @RequestMapping(value="/profile", method = RequestMethod.DELETE)
    public ModelAndView profileDelete() {
        Profile profile = new Profile();
        ModelAndView mav = new ModelAndView("profile");
        mav.addObject("profile",profile);
        return mav;
    }
    @RequestMapping(value="/profile", method = RequestMethod.POST)
    public ModelAndView createProfile(@ModelAttribute Profile profile, final RedirectAttributes redirectAttributes) {
        if(profile.getId() == null || profile.getId().equals("")) {
            ModelAndView mav = new ModelAndView("redirect:/profile");
            return mav;
        }
        ModelAndView mav = new ModelAndView("redirect:/profile/" + profile.getId());
        if(profileDao.findById(profile.getId()) != null) {
            profileDao.update(profile);
        }
        else {
            profileDao.create(profile);
        }
        return mav;
    }

    @RequestMapping(value = {"/profile/{id}"}, method = RequestMethod.GET)
    public String showProfile(@PathVariable String id, @RequestParam Map<String,String> allRequestParams, Model model){
        if(profileDao.findById(id) == null && !allRequestParams.containsKey("firstname")) throw new NotFoundExcp(id);
        model.addAttribute("profile", profileDao.findById(id));
        if(allRequestParams.containsKey("brief")) {
            if(allRequestParams.get("brief").equals("true")){
                return "brief";
            }
        } else if (allRequestParams.containsKey("firstname")) {
            String firstname = allRequestParams.get("firstname");
            Profile p = new Profile();
            p.setId(id);
            p.setFirstname(firstname);
            if (allRequestParams.containsKey("lastname")) {
                p.setLastname(allRequestParams.get("lastname"));
            }
            if (allRequestParams.containsKey("address")) {
                p.setAddress(allRequestParams.get("address"));
            }
            if (allRequestParams.containsKey("email")) {
                p.setEmail(allRequestParams.get("email"));
            }
            if (allRequestParams.containsKey("organization")) {
                p.setOrganization(allRequestParams.get("organization"));
            }
            if (allRequestParams.containsKey("aboutmyself")) {
                p.setAboutmyself(allRequestParams.get("aboutmyself"));
            }

            if(profileDao.findById(id) != null) {
                profileDao.update(p);
            }
            else {
                profileDao.create(p);
            }

            model.addAttribute("profile", p);
            return "redirect:/profile/" + id;
        }
        return "detail";
    }

//    @RequestMapping(value={"/profile/{id}"}, method = RequestMethod.POST)
//    public ModelAndView postProfile(@ModelAttribute Profile profile, @RequestParam(value="action") String action,
//                                    @PathVariable String id, final RedirectAttributes redirectAttributes) {
//        if(action.equals("delete")) {
//            ModelAndView mav = new ModelAndView("redirect:/redirectdelete");
//            profile = profileDao.delete(String.valueOf(id));
//            return mav;
//        }
//        ModelAndView mav = new ModelAndView("redirect:/profile/" + id);
//        if(profileDao.findById(id) != null) {
//            profileDao.update(profile);
//        }
//        else {
//            profileDao.create(profile);
//        }
//        return mav;
//    }

    @RequestMapping(value={"/profile/{id}"}, method = RequestMethod.POST)
    public ModelAndView postProfileDetail(@ModelAttribute Profile profile, @RequestParam Map<String,String> allRequestParams,
                                         @PathVariable String id, final RedirectAttributes redirectAttributes) {

        if(allRequestParams.containsKey("action")) {
            if (allRequestParams.get("action").equals("delete")) {
                ModelAndView mav = new ModelAndView("redirect:/redirectafterdelete");
                profile = profileDao.delete(String.valueOf(id));
                return mav;
            }
        }

        Profile newProfile = new Profile();
        newProfile.setId(id);
        if(allRequestParams.containsKey("firstname")) {
            newProfile.setFirstname(allRequestParams.get("firstname"));
        }
        if(allRequestParams.containsKey("lastname")) {
            newProfile.setLastname(allRequestParams.get("lastname"));
        }
        if(allRequestParams.containsKey("email")) {
            newProfile.setEmail(allRequestParams.get("email"));
        }
        if(allRequestParams.containsKey("address")) {
            newProfile.setAddress(allRequestParams.get("address"));
        }
        if(allRequestParams.containsKey("organization")) {
            newProfile.setOrganization(allRequestParams.get("organization"));
        }
        if(allRequestParams.containsKey("aboutmyself")) {
            newProfile.setAboutmyself(allRequestParams.get("aboutmyself"));
        }

        if(profileDao.findById(id) != null) {
            profileDao.update(newProfile);
        }
        else {
            profileDao.create(newProfile);
        }
        ModelAndView mav = new ModelAndView("redirect:/profile/" + id);
        return mav;


    }


    @RequestMapping(value={"/profile/{id}"}, method = RequestMethod.DELETE)
    public ModelAndView deleteProfile(@PathVariable String id, final RedirectAttributes redirectAttributes) {
        if(profileDao.findById(id) == null ) throw new NotFoundExcp(id);
        ModelAndView mav = new ModelAndView("redirect:/redirectafterdelete");
        Profile profile = profileDao.delete(id);
        return mav;
    }

    @RequestMapping(value="/redirectafterdelete")
    public View redirectDelete(final RedirectAttributes redirectAttributes) {
        RedirectView redirect = new RedirectView("/profile");
        redirect.setExposeModelAttributes(false);
        return redirect;
    }


    @ExceptionHandler(NotFoundExcp.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String pageNotFound() throws Exception {
        return "404";
    }




}

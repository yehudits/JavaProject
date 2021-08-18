/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Pages.ManagedBeans;

import com.mycompany.mavenproject2.DataLayer.Show;
import com.mycompany.mavenproject2.Services.ShowDetailsService;
import com.mycompany.mavenproject2.Services.ShowsListService;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import com.mycompany.mavenproject2.LoginProcess.LoginProcess;


/**
 *
 * @author HP
 */

@Named
@ViewScoped
public class ShowsListBean implements Serializable{
    
    private ShowsListService showsListService;
    private LoginProcess LoginProcess;
    private List<Show> shows;
    private ShowDetailsBean selectedShow = new ShowDetailsBean();
    private String showImg = "data:image/jpeg;base64,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";
    public ShowsListBean(){
       this.showsListService = new ShowsListService();
       this.LoginProcess = new LoginProcess();
       this.shows = this.showsListService.getAllShows();
    }

    public String getShowImg() {
        return showImg;
    }

    public void setShowImg(String showImg) {
        this.showImg = showImg;
    }

    
    public LoginProcess getLoginProcess(){
        return LoginProcess;
    }

    /*   public boolean isUserAdmin(){
    boolean res = this.LoginProcess.isUserType();
    return LoginProcess.isUserType();
    }*/
    public void setLoginProcess(LoginProcess LoginProcess) {
        this.LoginProcess = LoginProcess;
    }

    public String onSubmit() {
        return "index.html";
    }
    
    public String navigateToDetails(int showId){
        Show show = null;
        for(Show s : this.shows){
            if (s.getId() == showId){
                show = s;
            }
        }
        ShowDetailsService.setShow(show);
        return "showDetails.xhtml";
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
    
    public String addShowOrManager(int pageType){
        if(pageType==1){
            return "createShow.xhtml";
        }
        else{
            return "addAdmin.xhtml";
        }
    }
    
}

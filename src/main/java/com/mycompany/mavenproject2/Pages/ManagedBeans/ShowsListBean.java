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
    public ShowsListBean(){
       this.showsListService = new ShowsListService();
       this.LoginProcess = new LoginProcess();
       this.shows = this.showsListService.getAllShows();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Pages.ManagedBeans;

import com.mycompany.mavenproject2.DB.DBConnector;
import com.mycompany.mavenproject2.DataLayer.Show;
import com.mycompany.mavenproject2.Services.ShowsListService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author HP
 */

@Named
@ViewScoped
public class ShowsListBean implements Serializable{
    
    private ShowsListService showsListService;
    private List<Show> shows;
    private ShowDetailsBean selectedShow = new ShowDetailsBean();
    public ShowsListBean(){
       this.showsListService = new ShowsListService();
       this.shows = this.showsListService.getAllShows();
    }
    
    
    public String onSubmit(){
        return "index.html";
    }
    
    public String navigateToDetails(int showId){
        Show show = null;
        for(Show s : this.shows){
            if (s.getId() == showId){
                show = s;
            }
        }
        this.selectedShow.setSelectedShow(show);
        return "showDetails.xhtml";
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
    
    
    
}

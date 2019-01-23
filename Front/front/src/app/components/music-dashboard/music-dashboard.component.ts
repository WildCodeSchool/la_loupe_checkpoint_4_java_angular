import { Component, OnInit } from '@angular/core';
import { Musique } from 'src/app/models/musique';
import { MusicService } from 'src/app/services/music.service';

@Component({
  selector: 'app-music-dashboard',
  templateUrl: './music-dashboard.component.html',
  styleUrls: ['./music-dashboard.component.css']
})
export class MusicDashboardComponent implements OnInit {

  public musics: Musique[];
  public music: Musique;

  public add = true; 

  private _serv: MusicService;
  constructor(param_serv: MusicService) { 
    this._serv = param_serv;
    this.music = new Musique();
  }

  public refresh(){
    this.add =  true;
    this.music = new Musique();
    this.listAllMusics();
  }

  // Get all Musics
  public listAllMusics(){
    this._serv.GetMusics().subscribe(
      (data: any) => {
        this.musics = data;
      }
    );
  }

  // Add music
  public addMusic(){
    this._serv.createMusic(this.music).subscribe(
      () => {
        this.refresh();
        alert('Le musique a bien été ajoutée !');
      }
    )
  }

  public deleteMusic(id: number){
    const confirmation = confirm('Êtes-vous sûr de vouloir supprimer cette musique ?');
    if(confirmation) {
      this._serv.deleteMusic(id).subscribe(
        () => {
          this.refresh();
          alert('La musique a bien été supprimée !');
        }
      )
    }
  }

  public modifyMusic(id: number){
    this.add = false;
    this._serv.getMusic(id).subscribe(
      (data: any) => {
        this.music = data;
      }
    );
  }

  public updateMusic(){
    this._serv.updateMusic(this.music.id, this.music).subscribe(
        (data: any) => {
          this.refresh();
          alert('La musique a bien été modifiée !')
        }
    )
  }

  ngOnInit() {
    this.listAllMusics();
  }

}

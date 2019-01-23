import { Component, OnInit } from '@angular/core';
import { Musique } from 'src/app/models/musique';
import { MusicService } from 'src/app/services/music.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  public musics: Musique[];
  public music: Musique;

  private _serv: MusicService;
  constructor(param_serv: MusicService) { 
    this._serv = param_serv;

  }


  // Get all Musics
  public listAllMusics(){
    this._serv.GetMusics().subscribe(
      (data: any) => {
        this.musics = data;
      }
    );
  }

  ngOnInit() {
    this.listAllMusics();
  }

}

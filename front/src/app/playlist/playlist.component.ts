import { Component, OnInit } from '@angular/core';
import { SongsService } from 'src/app/services/songs.service';
import { Song } from 'src/app/models/song';


@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {

  public songs: Song[];


  // Inject services into the component
  private _serv: SongsService;
  


  constructor(param_serv: SongsService) { 
    this._serv = param_serv;
  }

  ngOnInit() {

    this._serv.getSongs().subscribe(
      (data) => {
        this.songs = data;
      }
    );
  
  }

    

}

import { Component, OnInit } from '@angular/core';
import { Song } from '../models/Song';
import { SongService } from 'src/app/services/song.service';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.scss']
})
export class PlaylistComponent implements OnInit {

  public songs: Song[]

  private serv: SongService;
  constructor(p_serv: SongService) { 
    this.serv = p_serv;
    this.songs = new Array<Song>();
  }

  public listAllSongs() {
    this.serv.listAllSongs().subscribe(
      (data: any) => {
        this.songs = data;
      }
    );
  }

  public updateSong(p_song: Song) {
    console.log(
      'updateSong called',
      p_song
    );
  }

  public deleteSong(p_song: Song) {
    this.serv.deleteSong(p_song.id.toString()).subscribe(
      () => {
        alert(`Removed ${p_song.artist} - ${p_song.name}`);
        this.ngOnInit();       
      }        
    );
  }

  ngOnInit() {
    this.listAllSongs();
  }

}

import { Component, OnInit } from '@angular/core';
import { Song } from '../models/Song';
import { SongService } from 'src/app/services/song.service';
import { PlaylistComponent } from '../playlist/playlist.component';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  public song: Song;
  private serv: SongService;
  constructor(p_serv: SongService) { 
    this.serv = p_serv;
    this.song = new Song();
  }

  public addSong(p_song: Song) {
    this.serv.addSong(p_song).subscribe(
      () => {
        alert(`Added ${p_song.artist} - ${p_song.name}`);
        this.ngOnInit();
      }
    );  
  }

  ngOnInit() {
  }

}

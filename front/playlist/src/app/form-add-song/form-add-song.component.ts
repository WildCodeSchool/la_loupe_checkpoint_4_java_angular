import { Component, OnInit } from '@angular/core';
import { Song } from '../song';
import { PlaylistService } from '../playlist.service';

@Component({
  selector: 'app-form-add-song',
  templateUrl: './form-add-song.component.html',
  styleUrls: ['./form-add-song.component.css']
})
export class FormAddSongComponent implements OnInit {

  public tmpSong:Song = new Song();
  private service: PlaylistService;

  constructor(private param_service: PlaylistService) {
    this.service = param_service;
   }

  ngOnInit() {
  }

  public addSong(){
    this.service.addSong(this.tmpSong).subscribe();
    this.tmpSong = new Song();
  }



}

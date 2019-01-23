import { Component, OnInit } from '@angular/core';
import { PlaylistService } from '../playlist.service';
import { Song } from '../song';
import { flush } from '@angular/core/testing';

@Component({
  selector: 'app-modif-or-delete',
  templateUrl: './modif-or-delete.component.html',
  styleUrls: ['./modif-or-delete.component.css']
})
export class ModifOrDeleteComponent implements OnInit {

  public currentSongId: number;
  public currentSong: Song = new Song();

  public tmpSong:Song;

  public display_title_tmpSong:boolean = false;
  public display_album_tmpSong:boolean = false;
  public display_artist_tmpSong:boolean = false;
  public display_url_tmpSong:boolean = false;

  private service: PlaylistService;

  constructor(private param_service: PlaylistService) {
    this.service = param_service;
  }

  ngOnInit() {
  }

  // CRUD 

  public selectSong() {
    this.service.getSong(this.currentSongId).subscribe(
      (param) => {
        this.currentSong = param;
      }
    );
  }

  public deleteSong(){
    this.service.deleteSong(this.currentSongId).subscribe();
  }

  public updateSong(){
    this.service.updateSong(this.currentSongId, this.tmpSong).subscribe();
    this.tmpSong = new Song();
  }


  // Display functions

  public switchTitleTmpSong(){
    this.display_title_tmpSong = !this.display_title_tmpSong;
  }

  public switchAlbumTmpSong(){
    this.display_album_tmpSong = !this.display_album_tmpSong;
  }

  public switchArtistTmpSong(){
    this.display_artist_tmpSong = !this.display_artist_tmpSong;
  }

  public switchUrlTmpSong(){
    this.display_url_tmpSong = !this.display_url_tmpSong;
  }
}

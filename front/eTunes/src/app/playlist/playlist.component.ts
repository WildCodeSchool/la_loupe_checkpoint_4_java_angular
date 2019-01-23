import { Component, OnInit } from '@angular/core';
import { Song } from '../song';
import { SongService } from '../song.service';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {

  public songList:Song[];

  public updateName:string;
  public updateArtist:string;
  public updateAlbum:string;

  public newName:string;
  public newArtist:string;
  public newAlbum:string;

  public newMusicInputs:boolean;

  public SongService:SongService
  constructor(songService:SongService) { 
    this.SongService = songService;
  }

  ngOnInit() {
    let ListSong;
    this.SongService.getSongs().subscribe(
      (param) => {
        this.songList = param;
      }
    );
    
    this.newMusicInputs = false;
  }

  fillUpdateInput(name, artist, album) {
    this.updateName = name;
    this.updateArtist = artist;
    this.updateAlbum = album;
  }

  updateCurrentSong(id,song){
    if (this.updateName != null && this.updateName != undefined && this.updateName != "") {
      song.name = this.updateName;
    }
    if (this.updateArtist != null && this.updateArtist != undefined  && this.updateArtist != "") {
      song.artist = this.updateArtist;
    }
    if (this.updateAlbum != null && this.updateAlbum != undefined  && this.updateAlbum != "") {
      song.album = this.updateAlbum;
    }

    this.SongService.editSong(id, song).subscribe(
      () => {
        this.ngOnInit();
      }
    );
  }

  deleteCurrentSong(id) {
    this.SongService.deleteSong(id).subscribe(
      () => {
        this.ngOnInit();
      }
    );
  }

  addSong() {

    let song = new Song("","","","")

    if (this.newName != null && this.newName != undefined) {
      song.name = this.newName;
    }
    if (this.newArtist != null && this.newArtist != undefined) {
      song.artist = this.newArtist;
    }
    if (this.newAlbum != null && this.newAlbum != undefined) {
      song.album = this.newAlbum;
    }

    this.SongService.addSong(song).subscribe(
      () => {
        this.ngOnInit();
        this.resetNewMusicinputs();
      }
    );
  }

  resetNewMusicinputs() {
    this.newName = "";
    this.newArtist = "";
    this.newAlbum = "";
  }

}

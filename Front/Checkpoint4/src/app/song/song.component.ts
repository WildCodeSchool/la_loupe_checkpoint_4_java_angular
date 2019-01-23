import { Component, OnInit, Input } from '@angular/core';
import { Song } from '../song';
import { SongService } from '../song.service';

@Component({
  selector: 'app-song',
  templateUrl: './song.component.html',
  styleUrls: ['./song.component.css']
})
export class SongComponent implements OnInit {

  @Input() public songData: Song;

  private songService: SongService;
  public songs: Song[];

  private editNameClicked: boolean = false;
  private editArtistClicked: boolean = false;
  private editAlbumClicked: boolean = false;

  constructor(param_service: SongService) {
    this.songService = param_service;
  }

  ngOnInit() {
    this.recupererSongs();
  }

  private recupererSongs(): void {
    this.songService.getSongs().subscribe(
      (param_song_list: Song[]) => {
        this.songs = param_song_list;
      }
    );
  }

  public editName(name: string) {
    this.editNameClicked = true;
    this.songData.name = name;
    this.updateSong(this.songData);
  }

  public validateName(name: string) {
    name = name.trim();
    if (name == "") {
      alert("Un texte est requis");
    } else {
      this.updateSong(this.songData);
      this.editNameClicked = false;
    }
  }

  public editArtist(artist: string) {
    this.editArtistClicked = true;
    this.songData.artist = artist;
    this.updateSong(this.songData);
  }

  public validateArtist(artist: string) {
    artist = artist.trim();
    if (artist == "") {
      alert("Un texte est requis");
    } else {
      this.updateSong(this.songData);
      this.editArtistClicked = false;
    }
  }

  public editAlbum(album: string) {
    this.editAlbumClicked = true;
    this.songData.album = album;
    this.updateSong(this.songData);
  }

  public validateAlbum(album: string) {
    album = album.trim();
    if (album == "") {
      alert("Un texte est requis");
    } else {
      this.updateSong(this.songData);
      this.editAlbumClicked = false;
    }
  }

  public updateSong(p_song: Song): void {
    this.songService.editSong(p_song.id, p_song).subscribe(
      //get response from server and edit the created question
      (data: Song) => {
        this.ngOnInit();
      }
    );
  }

}

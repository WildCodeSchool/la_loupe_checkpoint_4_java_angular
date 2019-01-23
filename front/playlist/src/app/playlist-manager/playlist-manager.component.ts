import { Component, OnInit } from '@angular/core';
import { PlaylistService } from '../playlist.service';
import { Song } from '../song';

@Component({
  selector: 'app-playlist-manager',
  templateUrl: './playlist-manager.component.html',
  styleUrls: ['./playlist-manager.component.css']
})
export class PlaylistManagerComponent implements OnInit {
  private playlistService: PlaylistService;
  public songs: Song[];
  public newSong: Song;

  constructor(p_playlistService: PlaylistService) {
    this.playlistService = p_playlistService;
    this.newSong = {name: '', artist: '', album: '', img: ''};
    this.songs = null;
  }

  ngOnInit(): void {

    this.playlistService.getAll().subscribe(
      (result: Song[]) => {
        this.songs = result;
      }
    );

  }

  public create(): void {
    this.playlistService.addSong(this.newSong).subscribe(
      (data: Song) => {
        this.ngOnInit();
        alert('A song have been added !');
      }
    );
  }

  public update(p_song): void {
    this.playlistService.editSong(p_song.id, p_song).subscribe(
      (data: Song) => {
        this.ngOnInit();
      }
    );
  }

  public delete(p_song): void {
    this.playlistService.deleteSong(p_song.id).subscribe(
      (data: boolean) => {
        this.ngOnInit();
      }
    );
  }

  public displayUpdateForm(p_SongId) {
    const updateBlock = document.getElementById(p_SongId);

    if (updateBlock.style.display === 'none') {
      updateBlock.style.display = 'block';
    } else {
      updateBlock.style.display = 'none';
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { PlaylistService } from '../playlist.service';
import { Song } from '../song';

@Component({
  selector: 'app-song-list',
  templateUrl: './song-list.component.html',
  styleUrls: ['./song-list.component.css']
})
export class SongListComponent implements OnInit {

  public songList: Song[];
  private service: PlaylistService;

  constructor(private param_service: PlaylistService) {
    this.service = param_service;
  }

  ngOnInit() {
    this.service.getAllSongs().subscribe(
      (param) => {
        this.songList = param;
      }
    );
  }

}

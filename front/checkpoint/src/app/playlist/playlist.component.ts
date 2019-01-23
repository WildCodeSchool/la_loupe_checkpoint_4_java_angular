import { Component, OnInit } from '@angular/core';
import { Playlist} from '../model/playlist';
import { PlaylistService } from '../service/playlist.service';
import { Router } from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {

  playlists: Playlist[];

  constructor(private router:Router, private service: PlaylistService) { }

  ngOnInit() {
    this.service.getPlaylists().subscribe(data => (this.playlists = data));
  }

  deletePlaylist(playlist: Playlist): void {
    this.service.deletePlaylist(playlist.id).subscribe(data => {
      this.playlists = this.playlists.filter(c => c !== playlist);
    })
    }
  

  editPlaylist(playlist: Playlist): void {
    localStorage.removeItem('editPlaylistId');
    localStorage.setItem('editPlaylistId', playlist.id.toString());
    this.router.navigate(['edit-playlist']);
  }

  addPlaylist(): void {
    this.router.navigate(['add-playlist']);
  }

}

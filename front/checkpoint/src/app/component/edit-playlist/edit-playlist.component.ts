import { Component, OnInit } from '@angular/core';
import { Playlist} from '../../model/playlist';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { PlaylistService } from '../../service/playlist.service';
import { Router } from '@angular/router';
import {first} from 'rxjs/operators';
import swal from 'sweetalert2';

@Component({
  selector: 'app-edit-playlist',
  templateUrl: './edit-playlist.component.html',
  styleUrls: ['./edit-playlist.component.css']
})
export class EditPlaylistComponent implements OnInit {

  playlist: Playlist;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private service: PlaylistService) { }

  ngOnInit() {

    const playlistId = localStorage.getItem('editPlaylistId');

    if ( !playlistId ) {
      alert('perdu');
      this.router.navigate(['list-playlist']);
      return;
    }

    this.editForm = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      artist: ['', Validators.required],
      album: ['', Validators.required],
      img: ['', Validators.required]
    });

    this.service.getPlaylist(+playlistId)
      .subscribe(data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.service.updatePlaylist(this.editForm.value)
      .pipe(first())
      .subscribe( data => {
        this.router.navigate(['list-playlist']);
         })
        }

  


}

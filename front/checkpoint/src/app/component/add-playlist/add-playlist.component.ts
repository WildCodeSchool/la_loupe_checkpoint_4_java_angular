import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PlaylistService } from '../../service/playlist.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-add-playlist',
  templateUrl: './add-playlist.component.html',
  styleUrls: ['./add-playlist.component.css']
})
export class AddPlaylistComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private service: PlaylistService) { }

  addForm: FormGroup;
  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      artist: ['', Validators.required],
      album: ['', Validators.required],
      img: ['', Validators.required]
    });
  }

  onSubmit() {
    this.service.createPlaylist( this.addForm.value )
      .subscribe(data => {
        this.router.navigate(['list-playlist']);
      });
  }
}

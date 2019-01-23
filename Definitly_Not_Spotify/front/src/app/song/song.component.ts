import { Component, OnInit, Input } from '@angular/core';
import { SongListComponent } from '../song-list/song-list.component';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-song',
  templateUrl: './song.component.html',
  styleUrls: ['./song.component.css']
})
export class SongComponent implements OnInit {

   // @Input() songsList:SongListComponent;
   @Input() public data:any;
   private api:ApiService;
   private displayForm = false;

   constructor(service:ApiService) {
      this.api = service;
   }

   ngOnInit() {
   this.api.apiGet("/songs/" + this.data.id).subscribe(
      (incoming) => {
         this.data = incoming;
         console.log(this.data);
      })
   }

   showForm() {
      this.displayForm = !this.displayForm;
   }

   submitChange() {
      this.api.apiPut("/songs/" + this.data.id, this.data).subscribe(
         (incoming) => {
            console.log(this.data);
            this.ngOnInit();
      })
   }

}

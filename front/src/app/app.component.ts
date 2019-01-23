import { Component } from '@angular/core';
import { SongsService } from 'src/app/services/songs.service';
import { Song } from 'src/app/models/song';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-app';

  public songs: Song[];


  // Inject services into the component
  private _serv: SongsService;
  


  constructor(param_serv: SongsService) { 
    this._serv = param_serv;
  }

  ngOnInit() {

    this._serv.getSongs().subscribe(
      (data) => {
        this.songs = data;
      }
    );
  
  }
}

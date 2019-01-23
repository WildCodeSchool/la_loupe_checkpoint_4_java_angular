import { Component } from '@angular/core';
import { SongService } from './song.service';
import { Song } from './song';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Checkpoint4';

  private songService: SongService;
  public songs: Song[];
  public newSong: Song;

  public ajoutSongClicked: boolean = false;

  constructor(param_service: SongService) {
    this.songService = param_service;
    this.newSong = { name: "", artist: "", album: "", img: "" };
  }

  ngOnInit() {
    this.recupererSongs();
  }

  /*******************************************************************************/
  private recupererSongs(): void {
    this.songService.getSongs().subscribe(
      (param_song_list: Song[]) => {
        this.songs = param_song_list;
      }
    );
  }

  public createSong(): void {
    this.songService.addSong(this.newSong).subscribe(
      //get response from server and edit the created song
      (data: Song) => {
        this.sendImg();
        this.ngOnInit();
      }
    );
  }

  public updateSong(p_song: Song): void {
    this.songService.editSong(p_song.id, p_song).subscribe(
      //get response from server and edit the created song
      (data: Song) => {
        this.ngOnInit();
      }
    );
  }

  public deleteSong(p_song: Song): void {
    this.songService.deleteSong(p_song.id).subscribe(
      //get response from server and edit the created song
      (data: boolean) => {
        this.ngOnInit();
      }
    );
  }
  /*******************************************************************************/

  public beginNewSong() {
    this.ajoutSongClicked = true;
  }



  //Fonction envoi image
  public sendImg() {
    const inputImage: HTMLFormElement = <HTMLFormElement>document.getElementById('songImg');
    let ImageFile: FormData = new FormData(inputImage);
    this.songService.addImg(ImageFile).subscribe(
      (paramImageOk: any) => {

        if (paramImageOk == true) {
          alert("Votre image à bien été mise à jour !");
        } else {
          alert("Format incorrecte !");
        };
        this.ngOnInit();
      }
    );
  }

}

import { Component, OnInit } from "@angular/core";
import { Playlist } from "./playlist";
import { PlaylistService } from "./playlist.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  title = "playlist";
  public playlist: Playlist[];
  private playService: PlaylistService;
  public newChan: Playlist;
  public updateChan;
  public playlistById;
  public Id: number;

  constructor(param_service: PlaylistService) {
    this.playService = param_service;
    this.Id = 0;
    this.newChan = { name: "", artist: "", album: "", img: "" };
    this.updateChan = { name: "", artist: "", album: "", img: "" };
    this.playlistById = { name: "", artist: "", album: "", img: "" };
  }

  ngOnInit() {
    this.playService.getPlayl().subscribe((param_play: Playlist[]) => {
      this.playlist = param_play;
    });
  }

  public create(): void {
    if (
      this.newChan.name == "" ||
      this.newChan.artist == "" ||
      this.newChan.album == "" ||
      this.newChan.img == ""
    ) {
      alert("Merci de bien vouloir remplir les champs demandés.");
    } else {
      // this.doUpload();
      console.log(this.newChan);
      this.playService.addChan(this.newChan).subscribe((data: Playlist) => {
        this.ngOnInit();
        this.newChan = { name: "", artist: "", album: "", img: "" };
      });
    }
  }

  public getUpdate(p_id): void {
    this.playService.getById(p_id).subscribe((listbyid: Playlist) => {
      this.playlistById = listbyid;
    });
  }

  public putUpdate(p_chan: Playlist, p_id): void {
    // if (this.newActualite.photo != "") {
    //   this.doUpload();
    //   this.updateActu.photo = this.newActualite.photo;
    //   this.actuService.editActu(p_id, p_new).subscribe((data: Actu) => {
    //     this.ngOnInit();
    //     this.updateActu = { photo: "", texte: "", title: "" };
    //     this.newActualite.photo = "";
    //   });
    // }
    this.playService.editChan(p_id, p_chan).subscribe((data: Playlist) => {
      this.ngOnInit();
      this.updateChan = { name: "", artist: "", album: "", img: "" };
    });
  }

  // ont stock ip a supprimer
  public id(current_id): void {
    this.Id = current_id.id;
  }
  public delete(p_chan): void {
    this.playService.deleteChan(p_chan).subscribe((data: boolean) => {
      this.ngOnInit();
      this.Id = 0;
    });
  }
}

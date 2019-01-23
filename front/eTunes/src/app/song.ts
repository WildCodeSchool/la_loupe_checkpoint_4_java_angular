export class Song {

    public id:number;
    public name:string;
    public artist:string;
    public album: string;
    public img:string;
    private updateButton:boolean;
    
    constructor (name, artist, album, img) {
        
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.img = img;

        this.updateButton = false;
    }

    getUpdateButton() {
        return this.updateButton
    }
    setUpdateButton( updateButton:boolean) {
        this.updateButton = updateButton;
    }

}

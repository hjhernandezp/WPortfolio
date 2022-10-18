import { Injectable } from '@angular/core';
import { Storage, ref, uploadBytes, list, getDownloadURL } from '@angular/fire/storage';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  URLimagen: string = "";

  constructor(
    private storage: Storage
  ) { }

  public uploadImage($event: any, nombre: string) {
    const archivo = $event.target.files[0];
    const imagenref = ref(this.storage, 'imagenes/' + nombre);
    uploadBytes(imagenref, archivo)
      .then(response => {this.getImagen()})
      .catch(error => console.log(error))
  }

  getImagen() {
    const imagenref = ref(this.storage, 'imagenes/');
    list(imagenref)
      .then(async response => {
        for(let item of response.items) {
          this.URLimagen = await getDownloadURL(item)
        }
      })
      .catch(error => console.log(error))
  }
}

import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Estudios } from 'src/app/models/estudios';
import { EstudiosService } from 'src/app/services/estudios.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-estudios',
  templateUrl: './estudios.component.html',
  styleUrls: ['./estudios.component.css']
})
export class EstudiosComponent implements OnInit {
  
  //ARREGLO Y OBJETO
  arreglo: Estudios[] = [];
  objeto: Estudios = null;
  
  //DATOS
  carrera: string;
  mencion: string;
  estado: string;
  instituto: string
  lugar: string;

  //HABILITANTE
  isLogged = false;

  constructor(
    private ComService: EstudiosService, 
    private SerToken: TokenService,
    private ModalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.onLoad();
    if(this.SerToken.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  onLoad(): void {
    this.ComService.lista().subscribe(
      data => {
        this.arreglo = data
      }
    );
  }

  onReset(): void {
    this.carrera = null;
    this.mencion = null;
    this.estado = null;
    this.instituto
    this.lugar = null;
  }

  onLocate(id: number, referencia: any) {
    this.ComService.detail(id).subscribe(
      data => {
        this.objeto = data
      }, err => {
        alert("Error de sistema")
      }
    )
    this.ModalService.open(referencia)
  }

  onCreate(): void {
    const estudios = new Estudios(
      this.carrera, 
      this.mencion,
      this.estado,
      this.instituto,
      this.lugar
    );
    this.ComService.save(estudios).subscribe(
      data => {
        this.onLoad()
        this.onReset()
        alert("Registro añadido correctamente en: Estudios")
      }, err=> {
        alert("Error de sistema al añadir: Estudios")
      }
    );
  }

  onUpdate(id: number): void {
    this.ComService.update(id, this.objeto).subscribe(
      data => {
        this.onLoad()
        alert("Registro actualizado en: Estudios")
      }, err => {
        alert("Error de sistema al editar: Estudios")
      }
    );
  }

  onDelete(id: number) {
    if(id != undefined) {
      this.ComService.delete(id).subscribe(
        data => {
          this.onLoad()
          alert("Registro eliminado en: Estudios")
        }, err => {
          alert("Error de sistema al borrar: Estudios")
        }
      );
    }
  }

  openModal(referencia: any) {
    this.ModalService.open(referencia)
  }
}

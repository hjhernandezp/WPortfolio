import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/models/persona';
import { PersonaService } from 'src/app/services/persona.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  persona: Persona = null;

  constructor(
    private serPersona: PersonaService, 
    private serToken: TokenService
  ) { }

  isLogged = false;

  ngOnInit(): void {
    this.loadPesona();
    if(this.serToken.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  loadPesona() {
    this.serPersona.detail(1).subscribe(
      data => {
        this.persona = data
      }
    );
  }
}

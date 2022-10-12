export class Habilidades {
    id?: number;
    habNombre: string;
    habNivel: number;
    
    constructor(
        habNombre: string,
        habNivel: number
    ) {
        this.habNombre = habNombre;
        this.habNivel = habNivel;
    }
}

export class Experiencia {
    id?: number;
    expEmpresa: string;
    expLugar: string;
    expCargo: string;

    constructor(
        expEmpresa: string, 
        expLugar: string, 
        expCargo: string
    ) {
        this.expEmpresa = expEmpresa;
        this.expLugar = expLugar;
        this.expCargo = expCargo;
    }
}

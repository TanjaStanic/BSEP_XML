export class Certificate {
    serialNumberr : string;
    idIssuer : number;
    idSubject: number;
    ca : boolean;
    validFrom: Date;
    validTo: Date;
    revoked: boolean;
    reasonForRevokation: string;
}
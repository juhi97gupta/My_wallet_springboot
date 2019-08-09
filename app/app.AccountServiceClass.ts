import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Account } from "./app.Account";


@Injectable({
    providedIn: 'root'
})
export class AccountService{
   

    private baseUrl = 'http://localhost:5000/account';

    constructor(private http: HttpClient){}

    getCustomersList(): Observable<any> {
        return this.http.get(`${this.baseUrl}`  + `/all`);
      }
    
      createAccount(Account: Object): Observable<Object> {
        return this.http.put(`${this.baseUrl}` + `/add`, Account);
      }
    
      updateAccount(mobile: number, value: any): Observable<Object> {
        let object = {
          "id": value.id,
          "mobile": value.mobile,
          "accHolder": value.accHolder,
          "balance": value.balance

        }
       return this.http.put(`${this.baseUrl}/update/`+`${mobile}`, object);
       
      }
      getCustomersByMobile(mobileno: any): Observable<Account> {
       
        return this.http.get<Account>(`${this.baseUrl}/`+`${mobileno}`);
      }

     deleteAccount(mobile: number): Observable<any> {
       console.log(mobile)
       return this.http.delete(`${this.baseUrl}/delete/` +` ${mobile}`, { responseType: 'text' });
     }
     withdrawMoney(mobile: any,amount:any): Observable<any> {
       ///withdraw/mobile/{mobile}/amount/{amount}
      return this.http.get(`${this.baseUrl}/withdraw/mobile/${mobile}/amount/${amount}`);
    }
  
    transferMoney(from: any,to:any,amount:any): Observable<any> {
      ////amount/from/{from}/to/{to}/amount/{amount}
      console.log(`${this.baseUrl}/${from}/${to}/amount/${amount}`)
      return this.http.get(`${this.baseUrl}/${from}/${to}/amount/${amount}`);
    }
}
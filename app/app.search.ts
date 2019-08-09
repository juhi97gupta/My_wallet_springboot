import { Account } from "./app.Account";
import { AccountService } from "./app.AccountServiceClass";
import { Component } from "@angular/core";



@Component({
    selector: 'add-comp',
    templateUrl: 'search.html'
})
 export class SearchClass{
     ob: Account=new Account()
    constructor(private  service: AccountService){}
    mobile: any;
  account: Account;
  status = false;
  
    
    ngOnInit() {
        this.mobile;
      }
    
      private searchCustomers() {
        console.log("service")
        this.service.getCustomersByMobile(this.mobile)
          .subscribe(res => {this.ob = res;
          });
        
      }
    
      onSubmit() {
        this.searchCustomers();
      }
      
      onUpdate(){
        this.status = true;
      }
    
      deleteCustomer() {
          this.service.deleteAccount(this.ob.mobile)
          
        }
    
         updateCustomer() {
        this.service.updateAccount(this.ob.mobile,
          {id:this.ob.id, mobile: this.ob.mobile, accHolder: this.ob.accHolder,balance: this.ob.balance })
          .subscribe( data => {console.log(data)
              this.ob = data as Account;
 },
            error => console.log(error));
            this.status = false;
      }
    }
    
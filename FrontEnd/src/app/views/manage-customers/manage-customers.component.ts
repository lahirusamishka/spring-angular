import {Component, OnInit, ViewChild} from '@angular/core';
import {CustomerService} from "../../services/customer.service";
import {Customer} from "../../dtos/customer";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-manage-customers',
  templateUrl: './manage-customers.component.html',
  styleUrls: ['./manage-customers.component.css']
})
export class ManageCustomersComponent implements OnInit {

  customers: Array<Customer> = [];
  selectedCustomer: Customer = new Customer();
  tempCustomer: Customer = null;
  manuallySelected: boolean = false;
  @ViewChild("frmCustomers") frmCustomers: NgForm;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit() {
    this.loadAllCustomers();
  }

  loadAllCustomers(): void {
    this.customerService.getAllCustomers().subscribe(
      (result) => {
        this.customers = result;
        console.log(this.customers);
      }
    )
  }

  deleteCustomer(customer: Customer): void {
    if (confirm("Are you sure you want to delete this customer?")) {
      this.customerService.deleteCustomer(customer.id).subscribe(
        (result) => {
          if (result) {
            alert("Customer has been deleted successfully");
          } else {
            alert("Failed to delete the customer");
          }
          this.loadAllCustomers();
        }
      )
    }
  }

  selectCustomer(customer: Customer): void {
    this.clear();
    this.selectedCustomer = customer;
    this.tempCustomer = Object.assign({}, customer);
    this.manuallySelected = true;
  }

  clear(): void {
    let index = this.customers.indexOf(this.selectedCustomer);
    if (index !== -1) {
      this.customers[index] = this.tempCustomer;
      this.tempCustomer = null;
    }
    this.selectedCustomer = new Customer();
    this.manuallySelected = false;
  }

  saveCustomer(): void{
    this.customerService.saveCustomer(this.selectedCustomer).subscribe(
      (result)=>{
        if (result){
          alert("Customer has been saved successfully");
          this.loadAllCustomers();
        }else{
          alert("Failed to save the customer");
        }
      }
    )
  }

}

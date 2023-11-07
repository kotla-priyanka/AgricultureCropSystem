import { Component } from '@angular/core';
import { PaymentService } from '../payment.service';
import { PaymentTransaction } from './payment-model';
 
@Component({
  selector: 'app-payment-form',
  templateUrl: './payment-form.component.html',
  styleUrls: ['./payment-form.component.css']
})
export class PaymentFormComponent {
  payment: PaymentTransaction = new PaymentTransaction();
  isSuccess: boolean = false;
 
  constructor(private paymentService: PaymentService) {}
 
  processPayment() {
    this.paymentService.processPayment(this.payment).subscribe(
      (response) => {
        this.payment = response;
        this.isSuccess = response.status === 'SUCCESS';
      },
      (error) => {
        console.error('Error processing payment: ', error);
        this.isSuccess = false;
      }
    );
  }
}
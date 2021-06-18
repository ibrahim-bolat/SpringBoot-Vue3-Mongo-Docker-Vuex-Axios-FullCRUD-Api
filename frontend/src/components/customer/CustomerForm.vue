<template>
      <div class="CustomerForm">
        <form class="was-validated" @submit.prevent="newCustomer()">
          <div class="form-group">
            <label for="nameInput">Ad</label>
            <input type="text" class="form-control" id="nameInput" placeholder="Adınızı giriniz" required v-model="customer.customerName">
            <div class="valid-feedback">İyi görünüyor!</div>
            <div class="invalid-feedback">Lütfen Boş Bırakmayınız!</div>
          </div>
          <div class="form-group">
            <label for="surnameInput">Soyad</label>
            <input type="text" class="form-control" id="surnameInput" placeholder="Soyadınızı giriniz" required v-model="customer.customerSurName">
            <div class="valid-feedback">İyi görünüyor!</div>
            <div class="invalid-feedback">Lütfen Boş Bırakmayınız!</div>
          </div>
          <div class="form-group">
            <label for="languageSelect"></label>
            <select class="custom-select" id="languageSelect" required v-model="customer.language">
                <option value="">Yabancı Dil Seçiniz</option>
              <option value="Turkish">Turkish</option>
              <option value="English">English</option>
              <option value="Germany">Germany</option>
              <option value="French">French</option>
            </select>
            <div class="valid-feedback">İyi görünüyor!</div>
            <div class="invalid-feedback">Lütfen Bir Seçim Yapınız!</div>
          </div>
          <fieldset class="form-group">
          <div class="custom-control custom-radio">
            <input type="radio" class="custom-control-input" id="radioMan" name="radio-stacked" value="MALE" v-model="customer.gender">
            <label class="custom-control-label" for="radioMan">Erkek</label>
          </div>
          <div class="custom-control custom-radio">
            <input type="radio" class="custom-control-input" id="radioWoman" name="radio-stacked" required value="FEMALE" v-model="customer.gender">
            <label class="custom-control-label" for="radioWoman">Bayan</label>
            <div class="valid-feedback">İyi görünüyor!</div>
            <div class="invalid-feedback">Lütfen Bir Seçim Yapınız!</div>
          </div>
          </fieldset>
          <div class="form-group">
            <label for="phoneInput">Telefon</label>
            <input type="tel" class="form-control" id="phoneInput" placeholder="05305556677" pattern="[0]{1}[1-5]{1}[0-9]{9}" required v-model="customer.phoneNumber">
            <div class="valid-feedback">İyi görünüyor!</div>
            <div class="invalid-feedback">Lütfen Boş Bırakmayınız!</div>
          </div>
          <div class="form-group">
            <label for="emailInput">Email Adresi</label>
            <input type="email" class="form-control" id="emailInput" placeholder="Email giriniz" required v-model="customer.email">
            <div class="valid-feedback">İyi görünüyor!</div>
            <div class="invalid-feedback">Lütfen Boş Bırakmayınız!</div>
          </div>
          <div class="form-group">
            <label for="dateInput">Doğum Günü</label>
            <input type="date" class="form-control" id="dateInput" required v-model="customer.birthofDate">
            <div class="valid-feedback">İyi görünüyor!</div>
            <div class="invalid-feedback">Lütfen Bir Seçim Yapınız!</div>
          </div>
          <div class="form-group">
            <label for="passwordInput">Parola</label>
            <input type="password" class="form-control" id="passwordInput" placeholder="Parolanızı Giriniz" required v-model="customer.password">
            <div class="valid-feedback">İyi görünüyor!</div>
            <div class="invalid-feedback">Lütfen Boş Bırakmayınız!</div>
          </div>
          <button type="submit" class="btn btn-primary">Kayıt Ol</button>
        </form>
      </div>
  </template>
  
  <script>
    import {mapActions} from "vuex"
  export default {
    name: 'CustomerForm',
    data(){
     return{
       customer:{ 
          customerName: "", 
          customerSurName: "", 
          language: "", 
          gender: "", 
          phoneNumber: "", 
          email: "", 
          birthofDate: "", 
          password: "" 
       },
     }
    },
    methods: {
        ...mapActions(['addCustomer']),
        newCustomer(){
          this.addCustomer(this.customer)
          this.customer={}
        },
    }
  };
  </script>
  <style scoped>
    .CustomerForm{
   background-color:lightgoldenrodyellow;
   font-weight: bold;
   color: black;
   font-size: 16px;
  }
  .was-validated{
    margin:10px    
  }
  .btn{
       margin-bottom: 10px;
  }
</style>
  
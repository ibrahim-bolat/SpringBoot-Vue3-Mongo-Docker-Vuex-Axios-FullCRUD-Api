<template>
  <div class="bootstrap-modal">
    <div class="modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Kişi Güncelle</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true" @click="kapat()">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="CustomerForm">
                <form class="was-validated">
                <div class="form-group">
                    <label for="nameInput">Ad</label>
                    <input type="text" class="form-control" id="nameInput" placeholder="Adınızı giriniz" required v-model="updatedcustomer.customerName">
                    <div class="valid-feedback">İyi görünüyor!</div>
                    <div class="invalid-feedback">Lütfen Boş Bırakmayınız!</div>
                </div>
                <div class="form-group">
                    <label for="surnameInput">Soyad</label>
                    <input type="text" class="form-control" id="surnameInput" placeholder="Soyadınızı giriniz" required v-model="updatedcustomer.customerSurName">
                    <div class="valid-feedback">İyi görünüyor!</div>
                    <div class="invalid-feedback">Lütfen Boş Bırakmayınız!</div>
                </div>
                <div class="form-group">
                    <label for="languageSelect"></label>
                    <select class="custom-select" id="languageSelect" required v-model="updatedcustomer.language">
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
                    <input type="radio" class="custom-control-input" id="genderRadioMan" name="radio-stacked" value="MALE" v-model="updatedcustomer.gender">
                    <label class="custom-control-label" for="genderRadioMan">Erkek</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" class="custom-control-input" id="genderRadioWoman" name="radio-stacked" required value="FEMALE" v-model="updatedcustomer.gender">
                    <label class="custom-control-label" for="genderRadioWoman">Bayan</label>
                    <div class="valid-feedback">İyi görünüyor!</div>
                    <div class="invalid-feedback">Lütfen Bir Seçim Yapınız!</div>
                </div>
                </fieldset>
                <div class="form-group">
                    <label for="phoneInput">Telefon</label>
                    <input type="tel" class="form-control" id="phoneInput" placeholder="05305556677" pattern="[0]{1}[1-5]{1}[0-9]{9}" required v-model="updatedcustomer.phoneNumber">
                    <div class="valid-feedback">İyi görünüyor!</div>
                    <div class="invalid-feedback">Lütfen Boş Bırakmayınız!</div>
                </div>
                <div class="form-group">
                    <label for="emailInput">Email Adresi</label>
                    <input type="email" class="form-control" id="emailInput" placeholder="Email giriniz" required v-model="updatedcustomer.email">
                    <div class="valid-feedback">İyi görünüyor!</div>
                    <div class="invalid-feedback">Lütfen Boş Bırakmayınız!</div>
                </div>
                <div class="form-group">
                    <label for="dateInput">Doğum Günü</label>
                    <input type="date" class="form-control" id="dateInput" required v-model="updatedcustomer.birthofDate">
                    <div class="valid-feedback">İyi görünüyor!</div>
                    <div class="invalid-feedback">Lütfen Bir Seçim Yapınız!</div>
                </div>
                </form>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-primary" @click="guncelle()">Güncelle</button>
            <button type="button" class="btn btn-secondary" @click="kapat()">Kapat</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
    import {mapActions,mapGetters} from "vuex"
    import moment from "moment";
export default {
    name:"FormModal",
    data(){
     return{
       updatedcustomer:{ 
          customerId: "", 
          customerName: "", 
          customerSurName: "", 
          language: "", 
          gender: "", 
          phoneNumber: "", 
          email: "", 
          birthofDate: "", 
        }
     }
    },
    methods: {
        ...mapActions(['updateCustomer','cleanAndUpdateCustomer','changeDisplayModal']),
    format_date(value) {
      return moment(value).format("DD/MM/YYYY");
    },
    kapat() {
        this.$emit('close-modal-event');
      },
    guncelle() {
          this.cleanAndUpdateCustomer(this.updatedcustomer);
          this.updatedcustomer={}
          this.changeDisplayModal(false);
      },
    },
    computed:{
       ...mapGetters(['gettobeuptadedCustomer']),
    },
    created(){
        this.updatedcustomer={...(this.gettobeuptadedCustomer)}
    }
}
</script>
<style scoped>
  .modal {
    display: block;
  }
  .modal-body{
   background-color: lightgoldenrodyellow;
   color: black;

  }
</style>
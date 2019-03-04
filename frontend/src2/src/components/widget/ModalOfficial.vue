<!-- template for the modal component -->
<template>
<div>
<!--script type="text/x-template" id="modal-template"   @click="close" v-show="show"-->
  <transition name="modal-fade">
     <div class="modal-mask" @click="close">
      <div class="modal-wrapper">
        <div class="modal-container">

          <div class="modal-header">
            <slot name="header">
              default header
            </slot>
          </div>

          <div class="modal-body">
            <slot name="body">
              default body
            </slot>
          </div>

          <div class="modal-footer">
            <slot name="footer">
              default footer
              <button class="modal-default-button" @click="$emit('close')">
                OK
              </button>
            </slot>
          </div>
        </div>
      </div>
    </div>
  </transition>
  </div>
</template>

<script>
export default {
    name: 'ModalOfficial',
    props: ['show'],
    data: function () {
        return {
        showModal:false,
        title: '',
        body: ''
        };
    },
    methods: {/*
        close: function () {
            this.showModal=false;
            this.$emit('close');
            this.title = '';
            this.body = '';
        },*/
        savePost: function () {
          // Some save logic goes here...
            this.close();
        }
    },
    created(){
        this.showModal=this.show;
    },
    mounted() {
        /*
        document.addEventListener("keydown", (e) => {
        if (this.show && e.keyCode == 27) {
            this.close();
        }
        });
        */
     }
}
</script>

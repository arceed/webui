<template>
<div>
 <transition name="fade">  <!--modal, bounce, fade   -->
        <div class="modal-mask" @click="close" v-show="show">
            <div class="modal-container" @click.stop>
                <div class="modal-header">
                    <h3>New Post</h3>
                </div>
                <div class="modal-body">
                    <label class="form-label">
                        Title
                        <input v-model="title" class="form-control">
                    </label>
                    <label class="form-label">
                        Body
                        <textarea v-model="body" rows="5" class="form-control"></textarea>
                    </label>
                </div>
                <div class="modal-footer text-right">
                    <button class="modal-default-button" @click="savePost()">
                        Save
                    </button>
                </div>
            </div>
        </div>
    </transition>
 
</div>
</template>

<script>

export default {
    name: 'MyModal',
    props: ['show'],
    data: function () {
        return {
        title: '',
        body: ''
        };
    },
    methods: {
        close: function () {
            this.$emit('close');
            this.title = '';
            this.body = '';
        },
        savePost: function () {
          // Some save logic goes here...
            this.close();
        }
       },
    mounted: function () {
        document.addEventListener("keydown", (e) => {
        if (this.show && e.keyCode == 27) {
            this.close();
        }
        });
  }
}


</script>
<template>
    <div class="list">
        <ul class="types">
            <li class="" v-for="item in datalist">
                <component :is="child" :item="item" ></component>
                <button v-on:click='remove(index++)' type="button" name="button" class='red button postfix small'>Remover</button>
            </li>
        </ul>
    </div>
</template>
<script>
export default {
    name: 'search',
    props: ['child', 'list', 'defaults','section_name'],
    data () {
        return {
            index: 0,
            datalist: this.list
        }
    },
    methods: {
        add: function () {
            this.datalist.push(this.defaults)
        },
        getList () {
            return this.datalist;
        },
        remove(index){
            var datalist = [];
            for(var k in this.datalist){
                if(k != index) datalist.push(this.datalist[k]);
            }

            this.datalist = datalist;
        }
    }
}

</script>
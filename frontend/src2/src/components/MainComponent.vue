<template>
    <div class="parent">
        <List ref="link_list"
        :list="this.links"
        :child="'LinkFormItem'"
        :section_name="'Links'"
        :defaults="{content: '', type: 'facebook'}"></List>
    </div><!--

Child component is not updated when parent component model changes


in resume I have a list component and I can’t copy the data I pass as props to a modal property and use the model to render the list. I get several kinds of problems. The array I’m passing as props comes from an HTTP request so it takes longet than the component to mount.

So after some console.log I found out the following:

1- assigning the data in the HTTP response to a model in the parent component triggers the updated event in it as expected.

2- The HTTP Request is in the created event of the parent component. The events created, beforeMount and mounted in the child component (the list component) are executed as expected.

3- The HTTP Response comes after all the events in the child component are executed. At this time the updated method in the parent component is called. I change what is passed as props to the list component but ‘updated’ IS NOT called in the list component.
        Sep '17

It’s not updated because the 2 things are not bound together. You initialize datalist with the value of the property and that’s it. So datalist is not bound to the property. If the property change, datalist doesn’t get notified.
You do have a peculiar case. I did a control similar to this, for “chips” which were my data elements. But what I did was use slots and then bind directly to the parent data properties. And for the delete, I don’t delete it, I emit an event which then I map to the parent. My chip, once used, looks like this:
<chips size="medium" :items="itemList" @remove="rem">
    <template scope="text"><span :title="text.item.desc">{{text.item.name}}</span></template>
</chips>


        -->


</template>

<script>
export default {
    name: 'parent',
    data () {
        return {
            links: [],
        }
    },
    created: function () {
        console.log( 'parent component created')
        this.$http.get('http://localhost:8090/').then((response)=>{
            if (response.status === 200) {
                var data = response.body.data;
                this.links = data.links;
                console.log('parent component HTTP')
            } else {
                console.log('err', 'Some error has occurred')
            }
        }, function (err) {
            console.log('err', err)
        })
    }
}
</script>
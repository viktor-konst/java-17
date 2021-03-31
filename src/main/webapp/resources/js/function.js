function deleteStudents(){
    var items=$("input[type=checkbox]:checked");
    if(items.length==0){
        alert("Выберите хотябы одного студента!");
        return;
    }
    var ids="";
    for (var i=0;i<items.length;i++){
        ids= ids+$(items[i]).attr("value")+",";
    }
}
var setting = {
	check: {
		enable: true
	},
	data: {
		simpleData: {
			enable: true
		}
	}
};
//节点信息
var zNodes = [];

function getRoles(){
	
	var _id = $('#roleId').val();
	$.ajax({
		   type: 'POST',
		   url: path+'/admin/role/permission',
		   dataType: 'json',
		   data:{id:_id},
	  	   async: false,
		   success: function(msg){
			  zNodes = msg;
		   }
		});	
}

function sumbitPer(){
	
	var changeNode =zTree.getChangeCheckedNodes().length;
	if(changeNode == 0){
		alert("您并未更改权限");
	}
	var nodes = zTree.getCheckedNodes(true);
	var ids ='';
	if (nodes  && nodes.length>0) {
		$.each(nodes,function(k,v){
			ids +=v.id+",";
		});
//		alert(ids);
		updateRolePer(ids);
	}
}


function updateRolePer(_perIds){

	var _id = $('#roleId').val();
	$.ajax({
		   type: 'POST',
		   url: path+'/admin/role/permission/update',
		   dataType: 'json',
		   data:{id:_id,perIds:_perIds},
	  	   async: false,
		   success: function(msg){
			  if(navigator.userAgent.indexOf("MSIE")>0) {
					parent.document.execCommand('Refresh');
			  }else{
					parent.window.location.reload();
			  }
		   }
		});	
}

var zTree;
$(document).ready(function(){
	getRoles();
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	zTree = $.fn.zTree.getZTreeObj("treeDemo");
});



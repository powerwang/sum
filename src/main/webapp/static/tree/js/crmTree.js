var setting = {
	view: {
		dblClickExpand: false
	},
	check: {
		enable: true
	},
	callback: {
		onRightClick: OnRightClick
	},
	
};
// 节点信息
var zNodes = [];

function OnRightClick(event, treeId, treeNode) {
	if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
		zTree.cancelSelectedNode();
		showRMenu("root", event.clientX, event.clientY);
	} else if (treeNode && !treeNode.noR) {
		zTree.selectNode(treeNode);
		showRMenu("node", event.clientX, event.clientY);
	}
}
function showRMenu(type, x, y) {
	$("#rMenu ul").show();
	rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"});

	$("body").bind("mousedown", onBodyMouseDown);
}

function hideRMenu() {
	if (rMenu) rMenu.css({"visibility": "hidden"});
	$("body").unbind("mousedown", onBodyMouseDown);
}

function onBodyMouseDown(event){
	if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
		rMenu.css({"visibility" : "hidden"});
	}
}

function close(){
	$('#myModal').modal('hide');
}

// 新增节点
var addCount = 1;
function addTreeNode() {
	
	$('#myModal').modal({
	    backdrop:true,
	    keyboard: false,
	    show:true
	});
	$('#description').focus();
	hideRMenu();
	if (zTree.getSelectedNodes()[0]) {
		$('#parentId').attr('value',zTree.getSelectedNodes()[0].id);
	} else {
//		zTree.addNodes(null, newNode);
	}
}
// 修改节点
function updateTree(){
	

	$('#myModal').modal({
	    backdrop:true,
	    keyboard: false,
	    show:true
	});
	$('#description').focus();
	hideRMenu();
	if (zTree.getSelectedNodes()[0]) {
		getPermission(zTree.getSelectedNodes()[0].id);
	} else {
//		zTree.addNodes(null, newNode);
	}
}

// 删除节点
function removeTreeNode() {
	hideRMenu();
	var nodes = zTree.getSelectedNodes();
	if (nodes && nodes.length>0) {
//		if (nodes[0].children && nodes[0].children.length > 0) {
//			var msg = "要删除的节点是父节点，如果删除将连同子节点一起删掉。\n\n请确认！";
//			if (confirm(msg)==true){
//				zTree.removeNode(nodes[0]);
//			}
//		} else {
//			
//			zTree.removeNode(nodes[0]);
//		}
		delPermission(nodes[0].id);
	}
}

function delPermission(_id){
	
	window.location.href=path+'/admin/permission/delete/'+_id;
}

function getPermission(_id){
	$.ajax({
		   type: 'POST',
		   url: path+'/admin/permission/per',
		   dataType: 'json',
		   data:{id:_id},
	  	   async: false,
		   success: function(msg){
			   if(msg != null){
				   $('#parentId').attr('value',msg.perentId);
				   $('#permissionId').attr('value',msg.permission.id);
				   $('#description').attr('value',msg.permission.description);
				   $('#name').attr('value',msg.permission.name);
			   }
		   }
		});	
}

function getRoles(){
	$.ajax({
		   type: 'GET',
		   url: path+'/admin/permission/list',
		   dataType: 'json',
	  	   async: false,
		   success: function(msg){
			  zNodes = msg;
		   }
		});	
}

var zTree, rMenu;
$(document).ready(function(){
	getRoles();
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	zTree = $.fn.zTree.getZTreeObj("treeDemo");
	rMenu = $("#rMenu");
});



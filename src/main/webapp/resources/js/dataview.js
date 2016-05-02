$(document).ready(function() {
	$("#jqGrid").jqGrid({
		url : 'view/xml',
		mtype : "GET",
		datatype : 'json',
		jsonReader : {
			repeatitems : false,
			total : function(result) {
				return Math.ceil(result.total / result.max);
			},
			records : function(result) {
				return result.total;
			}
		},
		colModel : [ {
			label : 'Артист',
			name : 'artist',
			width : 75,
			sorttype: 'text',
			sortable: 'true'
		}, {
			label : 'Страна',
			name : 'country',
			width : 150,
			sorttype: 'text',
			sortable: 'true'
		}, {
			label : 'Цена',
			name : 'price',
			width : 150,
			sorttype: 'number',
			sortable: 'true'
		}, {
			label : 'Название CD',
			name : 'title',
			width : 150,
			sorttype: 'text',
			sortable: 'true',
			key : true
		}, {
			label : 'Год',
			name : 'year',
			width : 150,
			sorttype: 'int',
			sortable: 'true'
		} ],
		viewrecords : true,
		height : 'auto',
		autowidth: true, 
		shrinkToFit: true,
		rowNum : 20,
		rows : 'max',

		pager : "#jqGridPager"
	});
});
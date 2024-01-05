/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let flight = {
    init: function () {
       
        flight.deleteFlight();
    },
   
    deleteFlight: function () {
        $('.flight__button__deleteFlight').each(function () {
            $(this).on("click", function () {
                //e.preventDefault();
                let id = $(this).data('id');
                let tr = $(this).closest('tr');
                
                Swal.fire({
                    title: 'Are you sure?',
                    text: 'Do you want to delete Flight?',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, Detele it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: 'POST',
                            url: 'delete-flight',
                            data: {id: id},
                            success: function () {
                                Swal.fire(
                                        'Changed!',
                                        'Your file has been changed.',
                                        'success'
                                        );
                                tr.remove();
                            }
                        });
                    }
                });
            });
        });
    }
}
flight.init();


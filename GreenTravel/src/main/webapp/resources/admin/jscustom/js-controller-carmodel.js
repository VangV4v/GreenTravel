/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let deleteCarModel =
        {
            init: function () {
                deleteCarModel.deleteCarModel();
            },
            deleteCarModel: function () {
                $('.carmodel__button__deleteCarModel').each(function () {
                    $(this).on("click", function () {
                        //e.preventDefault();
                        let id = $(this).data('id');
                        let tr = $(this).closest('tr');
                      
                        Swal.fire({
                            title: 'Are you sure?',
                            text: 'Do you want to delete Car Model?',
                            icon: 'warning',
                            showCancelButton: true,
                            confirmButtonColor: '#3085d6',
                            cancelButtonColor: '#d33',
                            confirmButtonText: 'Yes, Detele it!'
                        }).then((result) => {
                            if (result.isConfirmed) {
                                $.ajax({
                                    type: 'POST',
                                    url: 'delete-carmodel',
                                    data: {carmodelID: id},
                                    success: function () {
                                        Swal.fire(
                                                'Changed!',
                                                'Your file has been changed.',
                                                'success'
                                                );
                                        tr.remove();
                                        //location.href = "/GreenTravel/admin/home-employee";
                                    }
                                });
                            }
                        });
                    });
                });
            }
        };
deleteCarModel.init();

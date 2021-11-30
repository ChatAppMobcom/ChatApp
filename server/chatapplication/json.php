<?php

    $localhost = "localhost";
    $db_username = "id16765538_chatapp";
    $db_password = "1dXfUGny~PzHuOVr";
    $db_name = "id16765538_db_chatapp";

    $conn = mysqli_connect($localhost, $db_username, $db_password) or die(mysqli_error()); //Database connection
    $db_select = mysqli_select_db($conn, $db_name) or die(mysqli_error()); //Database selection

    $query = "SELECT * FROM chat";
    $res = mysqli_query($conn, $query);

    $json_data = array();

    while($row = mysqli_fetch_assoc($res)) {
        $json_data[] = $row;
    }

    echo json_encode($json_data)

?>
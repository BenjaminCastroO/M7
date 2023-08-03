#Consulta 1
SELECT Plato.Nombre, Detalle_Pedido.Cantidad
FROM Plato
JOIN Detalle_Pedido ON Plato.ID = Detalle_Pedido.Plato_ID
WHERE Detalle_Pedido.Pedido_ID = 1;

#Consulta 2
SELECT Mesa_ID, COUNT(*) AS Cantidad_de_Pedidos
FROM Pedido
GROUP BY Mesa_ID;

#Consulta 3
SELECT C.Nombre AS Nombre_Camarero, SUM(DP.Subtotal) AS Monto_Ventas
FROM Camarero C
JOIN Pedido P ON C.ID = P.Camarero_ID
JOIN Detalle_Pedido DP ON P.ID = DP.Pedido_ID
GROUP BY C.ID, C.Nombre
ORDER BY Nombre_Camarero DESC;

#Consulta 4
SELECT Plato_ID, Nombre, SUM(Cantidad) AS Cantidad_Solicitudes
FROM Detalle_Pedido
JOIN Plato ON Detalle_Pedido.Plato_ID = Plato.ID
GROUP BY Plato_ID, Nombre
HAVING SUM(Cantidad) = (
    SELECT MAX(TotalSolicitudes) AS Maximo_Conteo
    FROM (
        SELECT Plato_ID, SUM(Cantidad) AS TotalSolicitudes
        FROM Detalle_Pedido
        GROUP BY Plato_ID
    ) AS CantidadesPlatos
);

#Consulta 5 
#(Ordenado por valor total)
SELECT P.Nombre AS Plato, SUM(DP.Subtotal) AS Valor_Total
FROM Plato P
JOIN Detalle_Pedido DP ON P.ID = DP.Plato_ID
GROUP BY P.ID, P.Nombre
ORDER BY Valor_Total ASC;

#Consulta 5 
#(Ordenado por nombre)
SELECT P.Nombre AS Plato, SUM(DP.Subtotal) AS Valor_Total
FROM Plato P
JOIN Detalle_Pedido DP ON P.ID = DP.Plato_ID
GROUP BY P.ID, P.Nombre
ORDER BY P.Nombre ASC;
(ns code-katas-1.core)

(defn filter-odd
  "Escribir una funcion que retorne solamente los numeros impares de
   una secuencia"
   [s]
   "esto solo funciona si se le da un rango por ejemplo 10 va a mostrar los impares pero no funciona con listas"
  ;(filter odd? (range s))
  "Al ver los test lo que se esta pasando es una lista, entonces lo anterior no funcionaba"
  (filter #(> (mod % 2) 0)s)
  )

(defn nil-key
  "Escribir una funcion que dada una clave y un mapa, devuelva true, solamente si el mapa
   contiene una entrada con esa clave, y su valor es nil"
  [k m]
  "Esta foma lo que hace es recorrer el vector si en la m(k) hay algo lo devuelve, sino devuelve nil"
  ;(get (m k))
  "otra forma puede ser con el contains"
  (if (contains? m k)
    (if (= (m k) nil)
      true)
    (else
      false)
    )
  )

(defn range
  "Escribir una funcion que cree una lista de enteros en un rango dado.
   Restricciones: range"
  [start end]
  "esto toma hasta end y devuelve la lista de lo que hay en el medio"
  ;(range start end)
  "como no me anda lo anterio, me da StackOverflowError, pero entiendo que la otra debería andar y la letra dicce no usa range"
  (take (- end start) (iterate inc start))
  )

(defn compress-sequence
  "Escribir una funcion que elimine los duplicados consecutivos
   de una secuencia"
  [s]
  "si me quedo con los primeros de cada una de las listas de identicos...debería funcionar..."
  (map first (partition-by identity s)) 
  )

(defn max-value
  "Escribir una funcion que reciba un numero variable de parametros
   y retorne el que tenga el valor mayor
   Restricciones: max y max-key"
  [& args]
  "ordeno la lista y luego selecciono el ultimo esto deberia andar tmb..."
  (last (sort args))
  )

(defn split-two
  "Escribir una funcion que parta una secuencia en dos partes
   Restricciones: split-at"
  [length s]
  "divido el vectos 2 con las cantidades que pasan en length"
  [(take length s) (drop length s)]
  )

(defn inter-two
  "Escribir una funcion que reciba dos secuencias y retorne el primero de cada una,
   luego el segundo de cada una, luego el tercero, etc.
   Restricciones: interleave"
  [s1 s2]
  "Funciona como map pero concatenado las disintas cadenas"
  (mapcat vector s1 s2)
  )

(defn retrieve-caps
  "Escribir una funcion que reciba un string y devuelva un nuevo string conteniendo
   solamente las mayusculas."
  [text]
  "primero flitro del texto los las letras entre A y Z y luego las uno con el apply str"
  (apply str (re-seq #"[A-Z]+" text))
  )

(defn find-truth
  "Escribir una funcion que tome un numero variable de booleans, y devuelva true
   solamente si alguno de los parametros son true, pero no todos son true. En otro
   caso debera retornar false"
  [& xs]
  "si no es nulo y alguno de los parametros es true, devuelvo true"
  (and (not= nil (some true? xs)) (not-every? true? xs))
  )

(defn zip-map
  "Escribir una funcion que reciba un vector de claves y un vector de valores, y
   construya un mapa a partir de ellos.
   Restricciones: zipmap"
  [k v]
  "armo con los sub mapas un mapa total"
  (apply merge (map hash-map k v))
  )

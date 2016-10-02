#load "pp.cma";;

open Pp;;
open List;;

#use "constantListKP41.ml";;

(* Move all units to a specific position *)
let rec moveGroup = function
	[] -> true
	| t::q -> actionOnPosition (t, aMove, (100.0, 100.0)) & moveGroup q;;

let example = function () -> moveGroup (getEntities MyCoalition);;

example();;
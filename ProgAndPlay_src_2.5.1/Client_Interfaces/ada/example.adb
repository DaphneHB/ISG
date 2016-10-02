with PP; use PP;
with ConstantListKP41; use ConstantListKP41;

-- Move all units to a specific position
procedure example is
	p : Position; -- target position
	u : Unit; -- current unit
	ct : Integer; -- loop counter
begin
	Open; -- open the Prog&Play API
	p.x := 100.0; -- x coordinate of the target position
	p.y := 100.0; -- y coordinate of the target position
	-- iterate all units
	ct := 0;
	while ct < GetNumUnits(MyCoalition) loop
		-- get current unit
		u := GetUnitAt(MyCoalition, ct);
		-- give a Move order
		CarryOutCommand(u, Move, p);
		ct := ct+1;
	end loop;
	Close; -- close the Prog&Play API
end example;
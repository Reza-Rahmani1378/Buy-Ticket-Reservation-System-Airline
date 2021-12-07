package ir.maktab.btrs.btrsa.repository;

import ir.maktab.btrs.btrsa.base.repository.BaseRepository;
import ir.maktab.btrs.btrsa.domain.Ticket;
import ir.maktab.btrs.btrsa.domain.dto.TicketDto;

import java.util.List;

public interface TicketRepository extends BaseRepository<Ticket, Long> {


    List<Ticket> searchByFromAndTo(TicketDto ticketDto);

    List<Ticket> sortByAirLineName(String name);

    List<Ticket> sortedByPrice(int choose);
}

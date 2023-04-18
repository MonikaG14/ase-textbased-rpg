package ase.project.domain.characters.player;

import java.util.Objects;
import java.util.UUID;

public class PlayerId {
    private final int id;
    public PlayerId() {
        this.id = getId();
    }

    public int getId() {
        UUID uuid = UUID.randomUUID();
        long uuidMostSigBits = uuid.getMostSignificantBits();
        long uuidLeastSigBits = uuid.getLeastSignificantBits();

        long longId = (uuidMostSigBits & 0xFFFFFFFFL) << 32 | (uuidLeastSigBits & 0xFFFFFFFFL);
        int intId = (int) (longId & 0xFFFFFFFFL);
        return Math.abs(intId);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this ) return true;
        if (!(object instanceof PlayerId)) return false;
        PlayerId other = (PlayerId) object;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
